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

import servizio.richieste.badge.mef.exception.NoSuchAnaDipExtException;
import servizio.richieste.badge.mef.model.AnaDipExt;
import servizio.richieste.badge.mef.model.impl.AnaDipExtImpl;
import servizio.richieste.badge.mef.model.impl.AnaDipExtModelImpl;
import servizio.richieste.badge.mef.service.persistence.AnaDipExtPersistence;

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
 * The persistence implementation for the ana dip ext service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnaDipExtPersistence
 * @see servizio.richieste.badge.mef.service.persistence.AnaDipExtUtil
 * @generated
 */
@ProviderType
public class AnaDipExtPersistenceImpl extends BasePersistenceImpl<AnaDipExt>
	implements AnaDipExtPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AnaDipExtUtil} to access the ana dip ext persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AnaDipExtImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtModelImpl.FINDER_CACHE_ENABLED, AnaDipExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtModelImpl.FINDER_CACHE_ENABLED, AnaDipExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CODICEFISCALEESTERNO =
		new FinderPath(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtModelImpl.FINDER_CACHE_ENABLED, AnaDipExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCodiceFiscaleEsterno",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICEFISCALEESTERNO =
		new FinderPath(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtModelImpl.FINDER_CACHE_ENABLED, AnaDipExtImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCodiceFiscaleEsterno",
			new String[] { String.class.getName() },
			AnaDipExtModelImpl.CF_DIP_EXT_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODICEFISCALEESTERNO = new FinderPath(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCodiceFiscaleEsterno",
			new String[] { String.class.getName() });

	/**
	 * Returns all the ana dip exts where cf_dip_ext = &#63;.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @return the matching ana dip exts
	 */
	@Override
	public List<AnaDipExt> findByCodiceFiscaleEsterno(String cf_dip_ext) {
		return findByCodiceFiscaleEsterno(cf_dip_ext, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ana dip exts where cf_dip_ext = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param start the lower bound of the range of ana dip exts
	 * @param end the upper bound of the range of ana dip exts (not inclusive)
	 * @return the range of matching ana dip exts
	 */
	@Override
	public List<AnaDipExt> findByCodiceFiscaleEsterno(String cf_dip_ext,
		int start, int end) {
		return findByCodiceFiscaleEsterno(cf_dip_ext, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ana dip exts where cf_dip_ext = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param start the lower bound of the range of ana dip exts
	 * @param end the upper bound of the range of ana dip exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ana dip exts
	 */
	@Override
	public List<AnaDipExt> findByCodiceFiscaleEsterno(String cf_dip_ext,
		int start, int end, OrderByComparator<AnaDipExt> orderByComparator) {
		return findByCodiceFiscaleEsterno(cf_dip_ext, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ana dip exts where cf_dip_ext = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param start the lower bound of the range of ana dip exts
	 * @param end the upper bound of the range of ana dip exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ana dip exts
	 */
	@Override
	public List<AnaDipExt> findByCodiceFiscaleEsterno(String cf_dip_ext,
		int start, int end, OrderByComparator<AnaDipExt> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICEFISCALEESTERNO;
			finderArgs = new Object[] { cf_dip_ext };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CODICEFISCALEESTERNO;
			finderArgs = new Object[] { cf_dip_ext, start, end, orderByComparator };
		}

		List<AnaDipExt> list = null;

		if (retrieveFromCache) {
			list = (List<AnaDipExt>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AnaDipExt anaDipExt : list) {
					if (!Objects.equals(cf_dip_ext, anaDipExt.getCf_dip_ext())) {
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

			query.append(_SQL_SELECT_ANADIPEXT_WHERE);

			boolean bindCf_dip_ext = false;

			if (cf_dip_ext == null) {
				query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_1);
			}
			else if (cf_dip_ext.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_3);
			}
			else {
				bindCf_dip_ext = true;

				query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AnaDipExtModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCf_dip_ext) {
					qPos.add(cf_dip_ext);
				}

				if (!pagination) {
					list = (List<AnaDipExt>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnaDipExt>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ana dip ext in the ordered set where cf_dip_ext = &#63;.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ana dip ext
	 * @throws NoSuchAnaDipExtException if a matching ana dip ext could not be found
	 */
	@Override
	public AnaDipExt findByCodiceFiscaleEsterno_First(String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator)
		throws NoSuchAnaDipExtException {
		AnaDipExt anaDipExt = fetchByCodiceFiscaleEsterno_First(cf_dip_ext,
				orderByComparator);

		if (anaDipExt != null) {
			return anaDipExt;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cf_dip_ext=");
		msg.append(cf_dip_ext);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnaDipExtException(msg.toString());
	}

	/**
	 * Returns the first ana dip ext in the ordered set where cf_dip_ext = &#63;.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ana dip ext, or <code>null</code> if a matching ana dip ext could not be found
	 */
	@Override
	public AnaDipExt fetchByCodiceFiscaleEsterno_First(String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator) {
		List<AnaDipExt> list = findByCodiceFiscaleEsterno(cf_dip_ext, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ana dip ext in the ordered set where cf_dip_ext = &#63;.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ana dip ext
	 * @throws NoSuchAnaDipExtException if a matching ana dip ext could not be found
	 */
	@Override
	public AnaDipExt findByCodiceFiscaleEsterno_Last(String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator)
		throws NoSuchAnaDipExtException {
		AnaDipExt anaDipExt = fetchByCodiceFiscaleEsterno_Last(cf_dip_ext,
				orderByComparator);

		if (anaDipExt != null) {
			return anaDipExt;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("cf_dip_ext=");
		msg.append(cf_dip_ext);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAnaDipExtException(msg.toString());
	}

	/**
	 * Returns the last ana dip ext in the ordered set where cf_dip_ext = &#63;.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ana dip ext, or <code>null</code> if a matching ana dip ext could not be found
	 */
	@Override
	public AnaDipExt fetchByCodiceFiscaleEsterno_Last(String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator) {
		int count = countByCodiceFiscaleEsterno(cf_dip_ext);

		if (count == 0) {
			return null;
		}

		List<AnaDipExt> list = findByCodiceFiscaleEsterno(cf_dip_ext,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ana dip exts before and after the current ana dip ext in the ordered set where cf_dip_ext = &#63;.
	 *
	 * @param id_dip_ext the primary key of the current ana dip ext
	 * @param cf_dip_ext the cf_dip_ext
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ana dip ext
	 * @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt[] findByCodiceFiscaleEsterno_PrevAndNext(long id_dip_ext,
		String cf_dip_ext, OrderByComparator<AnaDipExt> orderByComparator)
		throws NoSuchAnaDipExtException {
		AnaDipExt anaDipExt = findByPrimaryKey(id_dip_ext);

		Session session = null;

		try {
			session = openSession();

			AnaDipExt[] array = new AnaDipExtImpl[3];

			array[0] = getByCodiceFiscaleEsterno_PrevAndNext(session,
					anaDipExt, cf_dip_ext, orderByComparator, true);

			array[1] = anaDipExt;

			array[2] = getByCodiceFiscaleEsterno_PrevAndNext(session,
					anaDipExt, cf_dip_ext, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AnaDipExt getByCodiceFiscaleEsterno_PrevAndNext(Session session,
		AnaDipExt anaDipExt, String cf_dip_ext,
		OrderByComparator<AnaDipExt> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ANADIPEXT_WHERE);

		boolean bindCf_dip_ext = false;

		if (cf_dip_ext == null) {
			query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_1);
		}
		else if (cf_dip_ext.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_3);
		}
		else {
			bindCf_dip_ext = true;

			query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_2);
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
			query.append(AnaDipExtModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCf_dip_ext) {
			qPos.add(cf_dip_ext);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(anaDipExt);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AnaDipExt> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ana dip exts where cf_dip_ext = &#63; from the database.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 */
	@Override
	public void removeByCodiceFiscaleEsterno(String cf_dip_ext) {
		for (AnaDipExt anaDipExt : findByCodiceFiscaleEsterno(cf_dip_ext,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(anaDipExt);
		}
	}

	/**
	 * Returns the number of ana dip exts where cf_dip_ext = &#63;.
	 *
	 * @param cf_dip_ext the cf_dip_ext
	 * @return the number of matching ana dip exts
	 */
	@Override
	public int countByCodiceFiscaleEsterno(String cf_dip_ext) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODICEFISCALEESTERNO;

		Object[] finderArgs = new Object[] { cf_dip_ext };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ANADIPEXT_WHERE);

			boolean bindCf_dip_ext = false;

			if (cf_dip_ext == null) {
				query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_1);
			}
			else if (cf_dip_ext.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_3);
			}
			else {
				bindCf_dip_ext = true;

				query.append(_FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCf_dip_ext) {
					qPos.add(cf_dip_ext);
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

	private static final String _FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_1 =
		"anaDipExt.cf_dip_ext IS NULL";
	private static final String _FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_2 =
		"anaDipExt.cf_dip_ext = ?";
	private static final String _FINDER_COLUMN_CODICEFISCALEESTERNO_CF_DIP_EXT_3 =
		"(anaDipExt.cf_dip_ext IS NULL OR anaDipExt.cf_dip_ext = '')";

	public AnaDipExtPersistenceImpl() {
		setModelClass(AnaDipExt.class);
	}

	/**
	 * Caches the ana dip ext in the entity cache if it is enabled.
	 *
	 * @param anaDipExt the ana dip ext
	 */
	@Override
	public void cacheResult(AnaDipExt anaDipExt) {
		entityCache.putResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtImpl.class, anaDipExt.getPrimaryKey(), anaDipExt);

		anaDipExt.resetOriginalValues();
	}

	/**
	 * Caches the ana dip exts in the entity cache if it is enabled.
	 *
	 * @param anaDipExts the ana dip exts
	 */
	@Override
	public void cacheResult(List<AnaDipExt> anaDipExts) {
		for (AnaDipExt anaDipExt : anaDipExts) {
			if (entityCache.getResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
						AnaDipExtImpl.class, anaDipExt.getPrimaryKey()) == null) {
				cacheResult(anaDipExt);
			}
			else {
				anaDipExt.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ana dip exts.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnaDipExtImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ana dip ext.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnaDipExt anaDipExt) {
		entityCache.removeResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtImpl.class, anaDipExt.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AnaDipExt> anaDipExts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AnaDipExt anaDipExt : anaDipExts) {
			entityCache.removeResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
				AnaDipExtImpl.class, anaDipExt.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ana dip ext with the primary key. Does not add the ana dip ext to the database.
	 *
	 * @param id_dip_ext the primary key for the new ana dip ext
	 * @return the new ana dip ext
	 */
	@Override
	public AnaDipExt create(long id_dip_ext) {
		AnaDipExt anaDipExt = new AnaDipExtImpl();

		anaDipExt.setNew(true);
		anaDipExt.setPrimaryKey(id_dip_ext);

		return anaDipExt;
	}

	/**
	 * Removes the ana dip ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id_dip_ext the primary key of the ana dip ext
	 * @return the ana dip ext that was removed
	 * @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt remove(long id_dip_ext) throws NoSuchAnaDipExtException {
		return remove((Serializable)id_dip_ext);
	}

	/**
	 * Removes the ana dip ext with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ana dip ext
	 * @return the ana dip ext that was removed
	 * @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt remove(Serializable primaryKey)
		throws NoSuchAnaDipExtException {
		Session session = null;

		try {
			session = openSession();

			AnaDipExt anaDipExt = (AnaDipExt)session.get(AnaDipExtImpl.class,
					primaryKey);

			if (anaDipExt == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnaDipExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(anaDipExt);
		}
		catch (NoSuchAnaDipExtException nsee) {
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
	protected AnaDipExt removeImpl(AnaDipExt anaDipExt) {
		anaDipExt = toUnwrappedModel(anaDipExt);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anaDipExt)) {
				anaDipExt = (AnaDipExt)session.get(AnaDipExtImpl.class,
						anaDipExt.getPrimaryKeyObj());
			}

			if (anaDipExt != null) {
				session.delete(anaDipExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (anaDipExt != null) {
			clearCache(anaDipExt);
		}

		return anaDipExt;
	}

	@Override
	public AnaDipExt updateImpl(AnaDipExt anaDipExt) {
		anaDipExt = toUnwrappedModel(anaDipExt);

		boolean isNew = anaDipExt.isNew();

		AnaDipExtModelImpl anaDipExtModelImpl = (AnaDipExtModelImpl)anaDipExt;

		Session session = null;

		try {
			session = openSession();

			if (anaDipExt.isNew()) {
				session.save(anaDipExt);

				anaDipExt.setNew(false);
			}
			else {
				anaDipExt = (AnaDipExt)session.merge(anaDipExt);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !AnaDipExtModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((anaDipExtModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICEFISCALEESTERNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						anaDipExtModelImpl.getOriginalCf_dip_ext()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CODICEFISCALEESTERNO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICEFISCALEESTERNO,
					args);

				args = new Object[] { anaDipExtModelImpl.getCf_dip_ext() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CODICEFISCALEESTERNO,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CODICEFISCALEESTERNO,
					args);
			}
		}

		entityCache.putResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
			AnaDipExtImpl.class, anaDipExt.getPrimaryKey(), anaDipExt, false);

		anaDipExt.resetOriginalValues();

		return anaDipExt;
	}

	protected AnaDipExt toUnwrappedModel(AnaDipExt anaDipExt) {
		if (anaDipExt instanceof AnaDipExtImpl) {
			return anaDipExt;
		}

		AnaDipExtImpl anaDipExtImpl = new AnaDipExtImpl();

		anaDipExtImpl.setNew(anaDipExt.isNew());
		anaDipExtImpl.setPrimaryKey(anaDipExt.getPrimaryKey());

		anaDipExtImpl.setId_dip_ext(anaDipExt.getId_dip_ext());
		anaDipExtImpl.setNome_dip_ext(anaDipExt.getNome_dip_ext());
		anaDipExtImpl.setCognome_dip_ext(anaDipExt.getCognome_dip_ext());
		anaDipExtImpl.setCf_dip_ext(anaDipExt.getCf_dip_ext());
		anaDipExtImpl.setLuogonascita_dip_ext(anaDipExt.getLuogonascita_dip_ext());
		anaDipExtImpl.setDatanascita_dip_ext(anaDipExt.getDatanascita_dip_ext());

		return anaDipExtImpl;
	}

	/**
	 * Returns the ana dip ext with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ana dip ext
	 * @return the ana dip ext
	 * @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnaDipExtException {
		AnaDipExt anaDipExt = fetchByPrimaryKey(primaryKey);

		if (anaDipExt == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnaDipExtException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return anaDipExt;
	}

	/**
	 * Returns the ana dip ext with the primary key or throws a {@link NoSuchAnaDipExtException} if it could not be found.
	 *
	 * @param id_dip_ext the primary key of the ana dip ext
	 * @return the ana dip ext
	 * @throws NoSuchAnaDipExtException if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt findByPrimaryKey(long id_dip_ext)
		throws NoSuchAnaDipExtException {
		return findByPrimaryKey((Serializable)id_dip_ext);
	}

	/**
	 * Returns the ana dip ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ana dip ext
	 * @return the ana dip ext, or <code>null</code> if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
				AnaDipExtImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AnaDipExt anaDipExt = (AnaDipExt)serializable;

		if (anaDipExt == null) {
			Session session = null;

			try {
				session = openSession();

				anaDipExt = (AnaDipExt)session.get(AnaDipExtImpl.class,
						primaryKey);

				if (anaDipExt != null) {
					cacheResult(anaDipExt);
				}
				else {
					entityCache.putResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
						AnaDipExtImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
					AnaDipExtImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return anaDipExt;
	}

	/**
	 * Returns the ana dip ext with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id_dip_ext the primary key of the ana dip ext
	 * @return the ana dip ext, or <code>null</code> if a ana dip ext with the primary key could not be found
	 */
	@Override
	public AnaDipExt fetchByPrimaryKey(long id_dip_ext) {
		return fetchByPrimaryKey((Serializable)id_dip_ext);
	}

	@Override
	public Map<Serializable, AnaDipExt> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AnaDipExt> map = new HashMap<Serializable, AnaDipExt>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AnaDipExt anaDipExt = fetchByPrimaryKey(primaryKey);

			if (anaDipExt != null) {
				map.put(primaryKey, anaDipExt);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
					AnaDipExtImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AnaDipExt)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ANADIPEXT_WHERE_PKS_IN);

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

			for (AnaDipExt anaDipExt : (List<AnaDipExt>)q.list()) {
				map.put(anaDipExt.getPrimaryKeyObj(), anaDipExt);

				cacheResult(anaDipExt);

				uncachedPrimaryKeys.remove(anaDipExt.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AnaDipExtModelImpl.ENTITY_CACHE_ENABLED,
					AnaDipExtImpl.class, primaryKey, nullModel);
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
	 * Returns all the ana dip exts.
	 *
	 * @return the ana dip exts
	 */
	@Override
	public List<AnaDipExt> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ana dip exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ana dip exts
	 * @param end the upper bound of the range of ana dip exts (not inclusive)
	 * @return the range of ana dip exts
	 */
	@Override
	public List<AnaDipExt> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ana dip exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ana dip exts
	 * @param end the upper bound of the range of ana dip exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ana dip exts
	 */
	@Override
	public List<AnaDipExt> findAll(int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ana dip exts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AnaDipExtModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ana dip exts
	 * @param end the upper bound of the range of ana dip exts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ana dip exts
	 */
	@Override
	public List<AnaDipExt> findAll(int start, int end,
		OrderByComparator<AnaDipExt> orderByComparator,
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

		List<AnaDipExt> list = null;

		if (retrieveFromCache) {
			list = (List<AnaDipExt>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ANADIPEXT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ANADIPEXT;

				if (pagination) {
					sql = sql.concat(AnaDipExtModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AnaDipExt>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AnaDipExt>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ana dip exts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnaDipExt anaDipExt : findAll()) {
			remove(anaDipExt);
		}
	}

	/**
	 * Returns the number of ana dip exts.
	 *
	 * @return the number of ana dip exts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ANADIPEXT);

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
		return AnaDipExtModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ana dip ext persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AnaDipExtImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ANADIPEXT = "SELECT anaDipExt FROM AnaDipExt anaDipExt";
	private static final String _SQL_SELECT_ANADIPEXT_WHERE_PKS_IN = "SELECT anaDipExt FROM AnaDipExt anaDipExt WHERE id_dip_ext IN (";
	private static final String _SQL_SELECT_ANADIPEXT_WHERE = "SELECT anaDipExt FROM AnaDipExt anaDipExt WHERE ";
	private static final String _SQL_COUNT_ANADIPEXT = "SELECT COUNT(anaDipExt) FROM AnaDipExt anaDipExt";
	private static final String _SQL_COUNT_ANADIPEXT_WHERE = "SELECT COUNT(anaDipExt) FROM AnaDipExt anaDipExt WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "anaDipExt.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AnaDipExt exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AnaDipExt exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AnaDipExtPersistenceImpl.class);
}