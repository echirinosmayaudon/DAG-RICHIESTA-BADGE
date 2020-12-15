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

package servizio.prenotazione.aule.mef.service.persistence.impl;

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

import servizio.prenotazione.aule.mef.exception.NoSuchStrumentoTecException;
import servizio.prenotazione.aule.mef.model.StrumentoTec;
import servizio.prenotazione.aule.mef.model.impl.StrumentoTecImpl;
import servizio.prenotazione.aule.mef.model.impl.StrumentoTecModelImpl;
import servizio.prenotazione.aule.mef.service.persistence.StrumentoTecPersistence;

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
 * The persistence implementation for the strumento tec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrumentoTecPersistence
 * @see servizio.prenotazione.aule.mef.service.persistence.StrumentoTecUtil
 * @generated
 */
@ProviderType
public class StrumentoTecPersistenceImpl extends BasePersistenceImpl<StrumentoTec>
	implements StrumentoTecPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StrumentoTecUtil} to access the strumento tec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StrumentoTecImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecModelImpl.FINDER_CACHE_ENABLED, StrumentoTecImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecModelImpl.FINDER_CACHE_ENABLED, StrumentoTecImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCSTRUMENTO =
		new FinderPath(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecModelImpl.FINDER_CACHE_ENABLED, StrumentoTecImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDescStrumento",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO =
		new FinderPath(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecModelImpl.FINDER_CACHE_ENABLED, StrumentoTecImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDescStrumento",
			new String[] { String.class.getName() },
			StrumentoTecModelImpl.DESC_STRUMENTO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DESCSTRUMENTO = new FinderPath(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDescStrumento",
			new String[] { String.class.getName() });

	/**
	 * Returns all the strumento tecs where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @return the matching strumento tecs
	 */
	@Override
	public List<StrumentoTec> findByDescStrumento(String desc_strumento) {
		return findByDescStrumento(desc_strumento, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strumento tecs where desc_strumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_strumento the desc_strumento
	 * @param start the lower bound of the range of strumento tecs
	 * @param end the upper bound of the range of strumento tecs (not inclusive)
	 * @return the range of matching strumento tecs
	 */
	@Override
	public List<StrumentoTec> findByDescStrumento(String desc_strumento,
		int start, int end) {
		return findByDescStrumento(desc_strumento, start, end, null);
	}

	/**
	 * Returns an ordered range of all the strumento tecs where desc_strumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_strumento the desc_strumento
	 * @param start the lower bound of the range of strumento tecs
	 * @param end the upper bound of the range of strumento tecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching strumento tecs
	 */
	@Override
	public List<StrumentoTec> findByDescStrumento(String desc_strumento,
		int start, int end, OrderByComparator<StrumentoTec> orderByComparator) {
		return findByDescStrumento(desc_strumento, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strumento tecs where desc_strumento = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param desc_strumento the desc_strumento
	 * @param start the lower bound of the range of strumento tecs
	 * @param end the upper bound of the range of strumento tecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching strumento tecs
	 */
	@Override
	public List<StrumentoTec> findByDescStrumento(String desc_strumento,
		int start, int end, OrderByComparator<StrumentoTec> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO;
			finderArgs = new Object[] { desc_strumento };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DESCSTRUMENTO;
			finderArgs = new Object[] {
					desc_strumento,
					
					start, end, orderByComparator
				};
		}

		List<StrumentoTec> list = null;

		if (retrieveFromCache) {
			list = (List<StrumentoTec>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (StrumentoTec strumentoTec : list) {
					if (!Objects.equals(desc_strumento,
								strumentoTec.getDesc_strumento())) {
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

			query.append(_SQL_SELECT_STRUMENTOTEC_WHERE);

			boolean bindDesc_strumento = false;

			if (desc_strumento == null) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1);
			}
			else if (desc_strumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3);
			}
			else {
				bindDesc_strumento = true;

				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StrumentoTecModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesc_strumento) {
					qPos.add(desc_strumento);
				}

				if (!pagination) {
					list = (List<StrumentoTec>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StrumentoTec>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first strumento tec in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strumento tec
	 * @throws NoSuchStrumentoTecException if a matching strumento tec could not be found
	 */
	@Override
	public StrumentoTec findByDescStrumento_First(String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator)
		throws NoSuchStrumentoTecException {
		StrumentoTec strumentoTec = fetchByDescStrumento_First(desc_strumento,
				orderByComparator);

		if (strumentoTec != null) {
			return strumentoTec;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("desc_strumento=");
		msg.append(desc_strumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStrumentoTecException(msg.toString());
	}

	/**
	 * Returns the first strumento tec in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching strumento tec, or <code>null</code> if a matching strumento tec could not be found
	 */
	@Override
	public StrumentoTec fetchByDescStrumento_First(String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator) {
		List<StrumentoTec> list = findByDescStrumento(desc_strumento, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last strumento tec in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strumento tec
	 * @throws NoSuchStrumentoTecException if a matching strumento tec could not be found
	 */
	@Override
	public StrumentoTec findByDescStrumento_Last(String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator)
		throws NoSuchStrumentoTecException {
		StrumentoTec strumentoTec = fetchByDescStrumento_Last(desc_strumento,
				orderByComparator);

		if (strumentoTec != null) {
			return strumentoTec;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("desc_strumento=");
		msg.append(desc_strumento);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStrumentoTecException(msg.toString());
	}

	/**
	 * Returns the last strumento tec in the ordered set where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching strumento tec, or <code>null</code> if a matching strumento tec could not be found
	 */
	@Override
	public StrumentoTec fetchByDescStrumento_Last(String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator) {
		int count = countByDescStrumento(desc_strumento);

		if (count == 0) {
			return null;
		}

		List<StrumentoTec> list = findByDescStrumento(desc_strumento,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the strumento tecs before and after the current strumento tec in the ordered set where desc_strumento = &#63;.
	 *
	 * @param id_strumento the primary key of the current strumento tec
	 * @param desc_strumento the desc_strumento
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next strumento tec
	 * @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec[] findByDescStrumento_PrevAndNext(long id_strumento,
		String desc_strumento, OrderByComparator<StrumentoTec> orderByComparator)
		throws NoSuchStrumentoTecException {
		StrumentoTec strumentoTec = findByPrimaryKey(id_strumento);

		Session session = null;

		try {
			session = openSession();

			StrumentoTec[] array = new StrumentoTecImpl[3];

			array[0] = getByDescStrumento_PrevAndNext(session, strumentoTec,
					desc_strumento, orderByComparator, true);

			array[1] = strumentoTec;

			array[2] = getByDescStrumento_PrevAndNext(session, strumentoTec,
					desc_strumento, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected StrumentoTec getByDescStrumento_PrevAndNext(Session session,
		StrumentoTec strumentoTec, String desc_strumento,
		OrderByComparator<StrumentoTec> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STRUMENTOTEC_WHERE);

		boolean bindDesc_strumento = false;

		if (desc_strumento == null) {
			query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1);
		}
		else if (desc_strumento.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3);
		}
		else {
			bindDesc_strumento = true;

			query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2);
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
			query.append(StrumentoTecModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDesc_strumento) {
			qPos.add(desc_strumento);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(strumentoTec);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<StrumentoTec> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the strumento tecs where desc_strumento = &#63; from the database.
	 *
	 * @param desc_strumento the desc_strumento
	 */
	@Override
	public void removeByDescStrumento(String desc_strumento) {
		for (StrumentoTec strumentoTec : findByDescStrumento(desc_strumento,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(strumentoTec);
		}
	}

	/**
	 * Returns the number of strumento tecs where desc_strumento = &#63;.
	 *
	 * @param desc_strumento the desc_strumento
	 * @return the number of matching strumento tecs
	 */
	@Override
	public int countByDescStrumento(String desc_strumento) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DESCSTRUMENTO;

		Object[] finderArgs = new Object[] { desc_strumento };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STRUMENTOTEC_WHERE);

			boolean bindDesc_strumento = false;

			if (desc_strumento == null) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1);
			}
			else if (desc_strumento.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3);
			}
			else {
				bindDesc_strumento = true;

				query.append(_FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDesc_strumento) {
					qPos.add(desc_strumento);
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

	private static final String _FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_1 = "strumentoTec.desc_strumento IS NULL";
	private static final String _FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_2 = "strumentoTec.desc_strumento = ?";
	private static final String _FINDER_COLUMN_DESCSTRUMENTO_DESC_STRUMENTO_3 = "(strumentoTec.desc_strumento IS NULL OR strumentoTec.desc_strumento = '')";

	public StrumentoTecPersistenceImpl() {
		setModelClass(StrumentoTec.class);
	}

	/**
	 * Caches the strumento tec in the entity cache if it is enabled.
	 *
	 * @param strumentoTec the strumento tec
	 */
	@Override
	public void cacheResult(StrumentoTec strumentoTec) {
		entityCache.putResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecImpl.class, strumentoTec.getPrimaryKey(), strumentoTec);

		strumentoTec.resetOriginalValues();
	}

	/**
	 * Caches the strumento tecs in the entity cache if it is enabled.
	 *
	 * @param strumentoTecs the strumento tecs
	 */
	@Override
	public void cacheResult(List<StrumentoTec> strumentoTecs) {
		for (StrumentoTec strumentoTec : strumentoTecs) {
			if (entityCache.getResult(
						StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
						StrumentoTecImpl.class, strumentoTec.getPrimaryKey()) == null) {
				cacheResult(strumentoTec);
			}
			else {
				strumentoTec.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all strumento tecs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StrumentoTecImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the strumento tec.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(StrumentoTec strumentoTec) {
		entityCache.removeResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecImpl.class, strumentoTec.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<StrumentoTec> strumentoTecs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (StrumentoTec strumentoTec : strumentoTecs) {
			entityCache.removeResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
				StrumentoTecImpl.class, strumentoTec.getPrimaryKey());
		}
	}

	/**
	 * Creates a new strumento tec with the primary key. Does not add the strumento tec to the database.
	 *
	 * @param id_strumento the primary key for the new strumento tec
	 * @return the new strumento tec
	 */
	@Override
	public StrumentoTec create(long id_strumento) {
		StrumentoTec strumentoTec = new StrumentoTecImpl();

		strumentoTec.setNew(true);
		strumentoTec.setPrimaryKey(id_strumento);

		return strumentoTec;
	}

	/**
	 * Removes the strumento tec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_strumento the primary key of the strumento tec
	 * @return the strumento tec that was removed
	 * @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec remove(long id_strumento)
		throws NoSuchStrumentoTecException {
		return remove((Serializable)id_strumento);
	}

	/**
	 * Removes the strumento tec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the strumento tec
	 * @return the strumento tec that was removed
	 * @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec remove(Serializable primaryKey)
		throws NoSuchStrumentoTecException {
		Session session = null;

		try {
			session = openSession();

			StrumentoTec strumentoTec = (StrumentoTec)session.get(StrumentoTecImpl.class,
					primaryKey);

			if (strumentoTec == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStrumentoTecException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(strumentoTec);
		}
		catch (NoSuchStrumentoTecException nsee) {
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
	protected StrumentoTec removeImpl(StrumentoTec strumentoTec) {
		strumentoTec = toUnwrappedModel(strumentoTec);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(strumentoTec)) {
				strumentoTec = (StrumentoTec)session.get(StrumentoTecImpl.class,
						strumentoTec.getPrimaryKeyObj());
			}

			if (strumentoTec != null) {
				session.delete(strumentoTec);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (strumentoTec != null) {
			clearCache(strumentoTec);
		}

		return strumentoTec;
	}

	@Override
	public StrumentoTec updateImpl(StrumentoTec strumentoTec) {
		strumentoTec = toUnwrappedModel(strumentoTec);

		boolean isNew = strumentoTec.isNew();

		StrumentoTecModelImpl strumentoTecModelImpl = (StrumentoTecModelImpl)strumentoTec;

		Session session = null;

		try {
			session = openSession();

			if (strumentoTec.isNew()) {
				session.save(strumentoTec);

				strumentoTec.setNew(false);
			}
			else {
				strumentoTec = (StrumentoTec)session.merge(strumentoTec);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StrumentoTecModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((strumentoTecModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						strumentoTecModelImpl.getOriginalDesc_strumento()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCSTRUMENTO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO,
					args);

				args = new Object[] { strumentoTecModelImpl.getDesc_strumento() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_DESCSTRUMENTO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DESCSTRUMENTO,
					args);
			}
		}

		entityCache.putResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
			StrumentoTecImpl.class, strumentoTec.getPrimaryKey(), strumentoTec,
			false);

		strumentoTec.resetOriginalValues();

		return strumentoTec;
	}

	protected StrumentoTec toUnwrappedModel(StrumentoTec strumentoTec) {
		if (strumentoTec instanceof StrumentoTecImpl) {
			return strumentoTec;
		}

		StrumentoTecImpl strumentoTecImpl = new StrumentoTecImpl();

		strumentoTecImpl.setNew(strumentoTec.isNew());
		strumentoTecImpl.setPrimaryKey(strumentoTec.getPrimaryKey());

		strumentoTecImpl.setId_strumento(strumentoTec.getId_strumento());
		strumentoTecImpl.setDesc_strumento(strumentoTec.getDesc_strumento());
		strumentoTecImpl.setEmail_ref(strumentoTec.getEmail_ref());

		return strumentoTecImpl;
	}

	/**
	 * Returns the strumento tec with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the strumento tec
	 * @return the strumento tec
	 * @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStrumentoTecException {
		StrumentoTec strumentoTec = fetchByPrimaryKey(primaryKey);

		if (strumentoTec == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStrumentoTecException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return strumentoTec;
	}

	/**
	 * Returns the strumento tec with the primary key or throws a {@link NoSuchStrumentoTecException} if it could not be found.
	 *
	 * @param id_strumento the primary key of the strumento tec
	 * @return the strumento tec
	 * @throws NoSuchStrumentoTecException if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec findByPrimaryKey(long id_strumento)
		throws NoSuchStrumentoTecException {
		return findByPrimaryKey((Serializable)id_strumento);
	}

	/**
	 * Returns the strumento tec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the strumento tec
	 * @return the strumento tec, or <code>null</code> if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
				StrumentoTecImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		StrumentoTec strumentoTec = (StrumentoTec)serializable;

		if (strumentoTec == null) {
			Session session = null;

			try {
				session = openSession();

				strumentoTec = (StrumentoTec)session.get(StrumentoTecImpl.class,
						primaryKey);

				if (strumentoTec != null) {
					cacheResult(strumentoTec);
				}
				else {
					entityCache.putResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
						StrumentoTecImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
					StrumentoTecImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return strumentoTec;
	}

	/**
	 * Returns the strumento tec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_strumento the primary key of the strumento tec
	 * @return the strumento tec, or <code>null</code> if a strumento tec with the primary key could not be found
	 */
	@Override
	public StrumentoTec fetchByPrimaryKey(long id_strumento) {
		return fetchByPrimaryKey((Serializable)id_strumento);
	}

	@Override
	public Map<Serializable, StrumentoTec> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, StrumentoTec> map = new HashMap<Serializable, StrumentoTec>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			StrumentoTec strumentoTec = fetchByPrimaryKey(primaryKey);

			if (strumentoTec != null) {
				map.put(primaryKey, strumentoTec);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
					StrumentoTecImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (StrumentoTec)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_STRUMENTOTEC_WHERE_PKS_IN);

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

			for (StrumentoTec strumentoTec : (List<StrumentoTec>)q.list()) {
				map.put(strumentoTec.getPrimaryKeyObj(), strumentoTec);

				cacheResult(strumentoTec);

				uncachedPrimaryKeys.remove(strumentoTec.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(StrumentoTecModelImpl.ENTITY_CACHE_ENABLED,
					StrumentoTecImpl.class, primaryKey, nullModel);
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
	 * Returns all the strumento tecs.
	 *
	 * @return the strumento tecs
	 */
	@Override
	public List<StrumentoTec> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the strumento tecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strumento tecs
	 * @param end the upper bound of the range of strumento tecs (not inclusive)
	 * @return the range of strumento tecs
	 */
	@Override
	public List<StrumentoTec> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the strumento tecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strumento tecs
	 * @param end the upper bound of the range of strumento tecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of strumento tecs
	 */
	@Override
	public List<StrumentoTec> findAll(int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the strumento tecs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link StrumentoTecModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of strumento tecs
	 * @param end the upper bound of the range of strumento tecs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of strumento tecs
	 */
	@Override
	public List<StrumentoTec> findAll(int start, int end,
		OrderByComparator<StrumentoTec> orderByComparator,
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

		List<StrumentoTec> list = null;

		if (retrieveFromCache) {
			list = (List<StrumentoTec>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_STRUMENTOTEC);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STRUMENTOTEC;

				if (pagination) {
					sql = sql.concat(StrumentoTecModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<StrumentoTec>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<StrumentoTec>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the strumento tecs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (StrumentoTec strumentoTec : findAll()) {
			remove(strumentoTec);
		}
	}

	/**
	 * Returns the number of strumento tecs.
	 *
	 * @return the number of strumento tecs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STRUMENTOTEC);

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
		return StrumentoTecModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the strumento tec persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(StrumentoTecImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_STRUMENTOTEC = "SELECT strumentoTec FROM StrumentoTec strumentoTec";
	private static final String _SQL_SELECT_STRUMENTOTEC_WHERE_PKS_IN = "SELECT strumentoTec FROM StrumentoTec strumentoTec WHERE id_strumento IN (";
	private static final String _SQL_SELECT_STRUMENTOTEC_WHERE = "SELECT strumentoTec FROM StrumentoTec strumentoTec WHERE ";
	private static final String _SQL_COUNT_STRUMENTOTEC = "SELECT COUNT(strumentoTec) FROM StrumentoTec strumentoTec";
	private static final String _SQL_COUNT_STRUMENTOTEC_WHERE = "SELECT COUNT(strumentoTec) FROM StrumentoTec strumentoTec WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "strumentoTec.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No StrumentoTec exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No StrumentoTec exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(StrumentoTecPersistenceImpl.class);
}